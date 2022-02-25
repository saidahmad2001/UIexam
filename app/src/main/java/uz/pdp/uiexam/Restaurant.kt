package uz.pdp.uiexam

data class Restaurant(
    val image: String,
    val name: String,
    val location: String,
    val rating: Float,
    var isFavourite: Boolean
)
