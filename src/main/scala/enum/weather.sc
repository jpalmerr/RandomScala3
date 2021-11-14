enum Weather(riskOfRain: Float):
  def isHighRiskOfRain(): Boolean = riskOfRain > 0.5

  case Sunny extends Weather(0.1)
  case PartlyCloudy extends Weather(0.3)
  case Cloudy extends Weather(0.6)

Weather.Sunny.isHighRiskOfRain()
