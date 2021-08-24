package com.example.claseinicial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var rateList: Int? = null
    private lateinit var txvInfo: TextView
    private lateinit var bookList : Array<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txvInfo = findViewById(R.id.txvInfo)
        this.bookList = arrayOf<Book>()
    }

    fun showPhrase(view: View) {
        var numRandom = (0..5).random()
        when(numRandom) {
            0 -> {
                return Toast.makeText(this, "“Allí donde se queman los libros, se acaba por quemar a los hombres”. Heinrich Heine.", Toast.LENGTH_LONG).show()
            }
            1 -> {
                return Toast.makeText(this, "“Cuanto menos se lee, más daño hace lo que se lee”. Miguel de Unamuno.", Toast.LENGTH_LONG).show()
            }
            2 -> {
                return Toast.makeText(this, "“Un hogar sin libros es como un cuerpo sin alma”. Cicerón.", Toast.LENGTH_LONG).show()
            }
            3 -> {
                return Toast.makeText(this, "“Un libro es la única cosa inmortal”. Rufus Choate.", Toast.LENGTH_LONG).show()
            }
            4 -> {
                return Toast.makeText(this, "“La escritura es la pintura de la voz”. Voltaire.", Toast.LENGTH_LONG).show()
            }
            5 -> {
                return Toast.makeText(this, "“Leer un libro enseña más que hablar con su autor, porque el autor, en el libro, sólo ha puesto sus mejores pensamientos”. René Descartes", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun authorComments(view: View) {
        var numRandom = (0..2).random()
        when(numRandom) {
            0 -> {
                return Toast.makeText(this, "${bookList[rateList!!].author} es una eminencia creando obras literarias.", Toast.LENGTH_LONG).show()
            }
            1 -> {
                return Toast.makeText(this, "${bookList[rateList!!].author} es muy aclamado y reconocido por sus grandes obras.", Toast.LENGTH_LONG).show()
            }
            2 -> {
                return Toast.makeText(this, "Al leer ${bookList[rateList!!].author} es uno de los mejores escritores.", Toast.LENGTH_LONG).show()
            }
            3 -> {
                return Toast.makeText(this, "${bookList[rateList!!].author} es un muy buen libro, el cual no decepcionara", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun comments(view: View) {
        var numRandom = (0..5).random()
        when(numRandom) {
            0 -> {
                return Toast.makeText(this, "${bookList[rateList!!].title} es un libro fantastico, lleno de emociones.", Toast.LENGTH_LONG).show()
            }
            1 -> {
                return Toast.makeText(this, "${bookList[rateList!!].title} es muy aclamado por las críticas y muy recomendado.", Toast.LENGTH_LONG).show()
            }
            2 -> {
                return Toast.makeText(this, "Al leer ${bookList[rateList!!].title} sentiras que fue muy corto, de lo bueno que es.", Toast.LENGTH_LONG).show()
            }
            3 -> {
                return Toast.makeText(this, "${bookList[rateList!!].title} es un muy buen libro, el cual no decepcionara", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun createNewBook(view: View) {
        var book: Book
        var numRandom = (0..20).random()

        when(numRandom) {
            in 0..2 -> {
                book = Book("El jugador", "Fiódor Dostoyevski", null, "Es la historia de un hombre que se vuelve adicto a los juegos de azar y como esto conduce a una obsesión", 4)
            }
            in 3..5 -> {
                book = Book("El nombre del viento", "Patrick James Rothfuss", "Fantasía épica", "narra la historia de Kvothe arcanista, asesino, enamorado, músico, estudiante y aventurero; y de cómo se convirtió en un personaje legendario", 2)
            }
            in 6..8 -> {
                book = Book("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", "Aventura", "relata las aventuras y desventuras de un hidalgo de 50 años llamado Alonso Quijano, quien decide ser un caballero andante como aquellos que aparecen en sus libros de caballerías favoritos.", 3)
            }
            in 9..11 -> {
                book = Book("Divina comedia", "Dante Alighieri", null,"Cuenta el maravilloso viaje del autor por el Infierno, el Purgatorio y el Paraíso, guiado por Virgilio", null)
            }
            in 12..14 -> {
                book = Book("Los hermanos Karamázov", "Fiódor Dostoyevski", null,"Los hermanos Karamázov es un drama espiritual de luchas morales relacionadas con la fe, la duda, el juicio y la razón, contra una Rusia en proceso de modernización.", 12)
            }
            in 15..17 -> {
                book = Book("El cuidado necesario", "Leonardo Boff", null, "Es una reflexión de como vivir como seres con espíritu y asumir esta dimensión espiritual respecto de todo lo que hacemos.", 5)
            }
            else -> {
                book = Book("Pedro Páramo", "Juan Rulfo", null, "Juan Preciado, va en busca de su padre, Pedro Páramo, hasta el pueblo mexicano de Comala, un lugar vacio, misterioso, sin vida. Allí, el joven descubrirá que toda la gente del pueblo se llama Páramo", 5)
            }
        }

        var newArray = arrayOf<Book>(*bookList, book)
        this.bookList = newArray
        if ( rateList == null )
        {
            rateList = 0
        }
        else
        {
            rateList = rateList!! +1
        }

        Toast.makeText(this, "Se agrego un nuevo libro: ${book.title}", Toast.LENGTH_LONG).show()
        txvInfo.text = " título: ${book.title}" +
                "\n autor: ${book.author}" +
                "\n genero: ${book.genre}" +
                "\n descripción: ${book.description}" +
                "\n existencia: ${book.existence}"
    }

    fun getPreviousBook(view: View) {
        if (rateList == 0)
        {
            if (bookList.size != 1)
            {
                rateList = bookList.size-1
            }
        }
        else
        {
            rateList = rateList!!-1
        }

        txvInfo.text = " titulo: ${bookList[rateList!!].title}" +
                "\n autor: ${bookList[rateList!!].author}" +
                "\n genero: ${bookList[rateList!!].genre}" +
                "\n descripción: ${bookList[rateList!!].description}" +
                "\n existencia: ${bookList[rateList!!].existence}"

    }

    fun getNextBook(view: View) {
        if (rateList == (bookList.size-1))
        {
            rateList = 0
        }
        else
        {
            rateList = rateList!! +1
        }

        txvInfo.text = "título: ${bookList[rateList!!].title}" +
                "\n autor: ${bookList[rateList!!].author}" +
                "\n genero: ${bookList[rateList!!].genre}" +
                "\n descripción: ${bookList[rateList!!].description}" +
                "\n existencia: ${bookList[rateList!!].existence}"

    }

}