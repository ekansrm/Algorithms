package string;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by kami.wm on 27/03/2017.
 *
 */

public class TrieST<Value> {
  private static int R = 256;
  private Node root;
  private static class Node
  {
    private Object val;
    private Node[] next = new Node[R];
  }
  public Value get(String key) {
    Node x = get(root, key, 0);
    if (x==null) { return null;}
    return (Value) x.val;
  }

  // 返回以x为根节点的子单词查找树中与key相关联的值
  private Node get(Node x, String key, int d) {
    if(x==null) { return null; }
    if(d == key.length()) { return x; }
    char c = key.charAt(d);
    return get(x.next[c], key, d+1);
  }

  public void put(String key, Value val) {
    root = put(root, key, val, 0);
  }

  private Node put(Node x, String key, Value val, int d) {
    if (x == null) { x = new Node(); }
    if (d == key.length()) { x.val = val; return x; }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, val, d+1);
    return x;
  }
  public void delete(String key) {
    root = delete(root, key, 0);
  }

  private Node delete(Node x, String key, int d) {
    if (x == null) { return null; }
    if (key.length() == d) {
      x.val = null;
    } else {
      // 还没到目的节点, 递归
      char c = key.charAt(d);
      // 由递归可知, 如果 x.next[c] 被回收掉, x.next[c]会被置 null
      x.next[c] = delete(x.next[c], key, d+1);
    }
    if(x.val!=null) { return x;} // 当节点x并不是待删除的节点, 且还有值, 会走到这一步, 那么保留这个节点
    for (int i = 0; i < R; i++) {
      if (x.next[i] != null) { return x; }
    }
    // 到了这一步, 说明 x 的所有子节点都为空, 没有下一条了, 那么返回null, 断开x的父节点到x的连接, x会被垃圾回收机回收掉
    // 如果是C/C++等不会主动回收内存的语言, 在这里要把x主动回收掉
    return null;
  }

  public ArrayList<String> keys() { return keysWithPrefix(""); }

  public ArrayList<String> keysWithPrefix(String pre) {
    ArrayList<String> q = new ArrayList<String>();
    collect(get(root, pre, 0), pre, q);
    return q;
  }

  private void collect (Node x, String pre, ArrayList<String> q) {
    if(x==null) { return; }
    if(x.val!=null) { q.add(pre); }
    for (char c=0; c<R; c++) {
      if(x.next!=null) {collect(x.next[c], pre+c, q);}
    }

  }

  public ArrayList<String> keysThatMatch(String pat) {
    ArrayList<String> q = new ArrayList<String>();
    collect(root, "", pat, q);
    return q;
  }

  private void collect (Node x, String pre, String pat, ArrayList<String> q) {
    int d = pre.length();

    // 如果这个链接是无效的, 不用做下面的操作
    if (x == null) { return; }
    // 如果长度一致, 且当前节点是一个键值对, 那么返回这个key
    if (d == pat.length() && x.val != null) { q.add(pre); }
    // 长度已经吻合, 不用继续搜索
    if (d == pat.length()) { return; }

    // 注意索引从0开始, 所以pat[d]刚好是下一个要搜索的字符
    char next = pat.charAt(d);
    for (char c=0; c < R; c++) {
      // 在匹配的链接上继续搜索
      if (next == '.' || next == c) {
        collect(x.next[c], pre + c, pat, q);
      }
    }
  }

  public String longestPrefixOf(String s) {
    int length = search(root, s, 0, 0);
    return s.substring(0, length);
  }

  private int search(Node x, String s, int d, int length) {
    if (x == null) { return length; }
    // 不为空, 算最长前缀
    if (x.val != null) { length = d;}
    if (d == s.length()) { return length;}
    char c = s.charAt(d);
    return search(x.next[c], s, d+1, length);
  }


}
