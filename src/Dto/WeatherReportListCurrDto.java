package Dto;
public class WeatherReportListCurrDto {

	private String temp_c;
	private String feelslike_c;
	private String humidity;
	
	
	
	public String gettemp_c() {
		return temp_c;
	}
	public void settemp_c(String temp_c) {
		this.temp_c = temp_c;
	}

	public String getfeelslike_c() {
		return feelslike_c;
	}
	public void setfeelslike_c(String feelslike_c) {
		this.feelslike_c = feelslike_c;
	}
	
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}


}
