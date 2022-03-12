import scala.io.Source

object tp_dong{
  def main(args: Array[String]): Unit= {
    println("Program start")

    /*val read = scala.io.Source.fromFile("iris.data")
    val lines = scala.io.Source.fromFile("iris.data", "utf-8").getLines
    var tab: Array[Array[Any]] = Array()
    while(lines.hasNext){
      var ligne = lines.next().split(",")
      //print(ligne.toList.toString)
      //print(ligne(0).toDouble, ligne(1).toDouble, ligne(2).toDouble , ligne(3).toDouble, ligne(4) )
      tab = tab :+ Array(ligne(0).toDouble, ligne(1).toDouble, ligne(2).toDouble , ligne(3).toDouble, ligne(4).toString)
    }

    for(i<-0 until tab.length){
      for(j <-0 until tab(i).length){
        println(tab(i)(j))
      }
    }
    val close = read.close()*/

    /*val m = new Matrice( "iris.data" )
    m.read
    val m1 = m.get_Matrice()
    println(m1(1)(1))*/

    val k = new Kmeans()
    k.initialization("iris.data")
    /*
    println("Moyenne : "+k.mean(0))
    println("Ecart-type : "+k.standard_deviation(0))
    println("Variance : "+k.variance(0))
    println(k.getMatrice.getData(0).getCl)
    println(" ")
    */
    println(k.calculate(2))
    println(k.correlation(0,2))
    println("Program end")
  }
}