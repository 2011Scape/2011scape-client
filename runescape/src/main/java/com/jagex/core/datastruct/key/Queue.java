package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jga")
public final class Queue {

    @OriginalMember(owner = "client!jga", name = "f", descriptor = "Lclient!cm;")
    public Node2 pointer;

    @OriginalMember(owner = "client!jga", name = "h", descriptor = "Lclient!cm;")
    public final Node2 sentinel = new Node2();

    @OriginalMember(owner = "client!jga", name = "<init>", descriptor = "()V")
    public Queue() {
        this.sentinel.next2 = this.sentinel;
        this.sentinel.prev2 = this.sentinel;
    }

    @OriginalMember(owner = "client!jga", name = "c", descriptor = "(I)Lclient!cm;")
    public Node2 removeFirst() {
        @Pc(7) Node2 node = this.sentinel.next2;
        if (this.sentinel == node) {
            return null;
        } else {
            node.unlink2();
            return node;
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(ZLclient!cm;)V")
    public void add(@OriginalArg(1) Node2 node) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        node.next2 = this.sentinel;
        node.prev2 = this.sentinel.prev2;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(B)I")
    public int size() {
        @Pc(5) int size = 0;
        @Pc(17) Node2 current = this.sentinel.next2;
        while (this.sentinel != current) {
            current = current.next2;
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!jga", name = "b", descriptor = "(I)Lclient!cm;")
    public Node2 next() {
        @Pc(11) Node2 next = this.pointer;
        if (next == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = next.next2;
            return next;
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(Z)V")
    public void clear() {
        while (true) {
            @Pc(3) Node2 current = this.sentinel.next2;
            if (current == this.sentinel) {
                this.pointer = null;
                return;
            }
            current.unlink2();
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(I)Lclient!cm;")
    public Node2 first() {
        @Pc(18) Node2 first = this.sentinel.next2;
        if (first == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = first.next2;
            return first;
        }
    }

}
