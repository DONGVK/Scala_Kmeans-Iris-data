import scala.math.sqrt
import java.util.Scanner
import plotly._
import plotly.element._
import util.Random

class Kmeans(){
  var matrice: Matrice = _

  def initialization(file: String): Unit ={
    this.matrice = new Matrice(file)
    this.matrice.read
  }

  def mean(n: Int): Double ={
    var value = 0.0
    for( i <- 0 until matrice.getLength){
      value += matrice.getData(i).getValue(n)
    }
    return value/matrice.getLength
  }

  def mean(n: Int,start: Int, end: Int): Double ={
    var value = 0.0
    for( i <- start until end){
      value += matrice.getData(i).getValue(n)
    }
    return (value/end).toDouble
  }

  def standard_deviation(n: Int): Double ={
    var answer = 0.0
    for( i <- 0 until matrice.getLength){
      answer += (matrice.getData(i).getValue(n) - this.mean(n))*(matrice.getData(i).getValue(n) - this.mean(n))
    }
    sqrt(answer/matrice.getLength)
  }

  def standard_deviation(n: Int, start: Int, end: Int): Double ={
    var answer = 0.0
    for( i <- start until end){
      answer += (matrice.getData(i).getValue(n) - this.mean(n))*(matrice.getData(i).getValue(n) - this.mean(n))
    }
    sqrt(answer/end)
  }

  def variance(n: Int): Double ={
    this.standard_deviation(n)*this.standard_deviation(n)
  }

  def variance(n: Int, start: Int, end: Int): Double ={
    this.standard_deviation(n, start, end)*this.standard_deviation(n, start, end)
  }

  def calculate(n: Int): Unit ={
    if( n < 4) {
      println("[ Col : " + n+ " ]")
      println("Mean : " + this.mean(n))
      println("Standard variation : " + this.standard_deviation(n))
      println("Variance : " + this.variance(n))
    }else {
      println("The col " + n + " do not exist")
    }
  }

  def correlation(n: Int, m: Int): Double ={
    var x = this.mean(n)
    var y = this.mean(m)
    var x1 = this.standard_deviation(n)
    var y1 = this.standard_deviation(m)
    var answer = 0.0
    for( i <- 0 until matrice.getLength){
      answer += ( (matrice.getData(i).getValue(n) - x) / x1 ) * ( (matrice.getData(i).getValue(m) - y) / y1 )
    }
    answer/( matrice.getLength - 1.0 )
  }

  def getMatrice(): Matrice ={
    return matrice
  }


}