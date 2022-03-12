import scala.io.Source

class Matrice(private var fichier: String){
  var matrice : Array[Data] = Array()

  def Matrice(fichier: String): Unit ={
    this.read
  }

  def read(): Unit ={
    val read = scala.io.Source.fromFile(this.fichier, "utf-8")
    val lines = read.getLines
    //var tab : Array[Array[Any]] = Array()
    while(lines.hasNext){
      var ligne = lines.next().split(",")
      //tab = tab :+ Array(ligne(0).toDouble, ligne(1).toDouble, ligne(2).toDouble , ligne(3).toDouble, ligne(4).toString)
      matrice = matrice :+ new Data( Array(ligne(0).toString.toDouble, ligne(1).toString.toDouble, ligne(2).toString.toDouble , ligne(3).toString.toDouble), ligne(4).toString  )
    }
    val close = read.close()
  }

  def getData(i: Int): Data ={
    if( i <= matrice.length){
      return matrice(i)
    }
    return null
  }

  def getLength(): Int ={
    return matrice.length
  }

}