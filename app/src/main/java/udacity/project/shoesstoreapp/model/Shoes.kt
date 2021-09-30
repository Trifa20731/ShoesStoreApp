package udacity.project.shoesstoreapp.model

/**
 * The Shoes Class contain the attributes of a shoes detail.
 *
 * @property name The name of the shoes.
 * @property company The company name of the shoes.
 * @property size The size of the shoes.
 * @property description The description of the shoes.
 * */
data class Shoes(var name: String = "", var company: String = "", var size: String = "", var description: String = "")