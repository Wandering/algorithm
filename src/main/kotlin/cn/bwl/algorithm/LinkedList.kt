package cn.bwl.algorithm

/**
 * Created by Administrator on 2017/9/20.
 * 链表的kotlin实现
 */
class LinkedList<E>{
    val size:Int=0
    protected val modCount:Int=0
    private val first:Node<E>?=null
    private val last:Node<E>?=null

    /**
     * 向链表中添加节点
     */
    fun linkLast(e:E){
        val l = last
        val newNode:Node<E> = Node(l,e,null)

    }

    private class Node<E> internal constructor(internal var prev: Node<E>?, internal var item: E?, internal var next: Node<E>?)
}

