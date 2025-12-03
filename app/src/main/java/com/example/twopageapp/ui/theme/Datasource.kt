package com.example.twopageapp.ui.theme

import com.example.twopageapp.R

data class HomeItem(val text: String, val image: Int)

object Datasource {

    val items = listOf(
        HomeItem(
            "Item 1: Welcome to the app",
            R.drawable.item1
        ),
        HomeItem(
            "Item 2: This is a scrollable list",
            R.drawable.item2
        ),
        HomeItem(
            "Item 3: You can add whatever content you want",
            R.drawable.item3
        ),
        HomeItem(
            "Item 4: Maybe class notes or descriptions",
            R.drawable.item4
        ),
        HomeItem(
            "Item 5: More content...",
            R.drawable.item5
        ),
        HomeItem(
            "Item 6: Even more content...",
            R.drawable.item6
        ),
        HomeItem(
            "Item 7: Enough items to scroll",
            R.drawable.item7
        ),
        HomeItem(
            "Item 8: Keep going",
            R.drawable.item8
        ),
        HomeItem(
            "Item 9: Almost there",
            R.drawable.item9
        ),
        HomeItem(
            "Item 10: Last example item",
            R.drawable.item10
        )
    )
}
