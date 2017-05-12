package com.example.lenovo.tj.utils;

import java.util.List;

/**
 * date: 2017/5/12
 * author: 史洲铭(lenovo)
 * function:
 */

public class Event
{
    /** 列表加载事件 */
    public static class ItemListEvent
    {
        private List<Item> items;

        public ItemListEvent(List<Item> items)
        {
            this.items = items;
        }

        public List<Item> getItems()
        {
            return items;
        }
    }

}
