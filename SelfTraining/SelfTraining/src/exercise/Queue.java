/*
 * Class: Queue
 *
 * Created on Dec 15, 2016
 *
 * (c) Copyright Lam Research Corporation, unpublished work, created 2016
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Lam Research Corporation
 * 4000 N. First Street
 * San Jose, CA
 */
package practise;

/**
 * @author ViegasJ
 *
 */
public interface Queue<Item>
{
    final int INITIAL_LENGTH = 4;

    final int SHRINK_FACTOR = 4;

    final int INCREASE_FACTOR = 2;

    public Item deque();

    public void enque(Item data);

    public int size();
}
