class Data(private var values: Array[Double], private var classe: String){
  def getValue( i : Int): Double ={
    this.values(i)
  }

  def getValues(): Array[Double]={
    this.values
  }

  def getCl(): String ={
    this.classe
  }
}