package Dto;
import java.util.List;

public class WeatherResultDto {

	private List<WeatherReportListCurrDto> current;
	private List<WeatherReportListLocDto> location;
	
	
	public List<WeatherReportListCurrDto> getCurrent() {
		return current;
	}
	public void setCurrent(List<WeatherReportListCurrDto> current) {
		this.current = current;
	}
	
	public List<WeatherReportListLocDto> getLocation() {
		return location;
	}
	public void setLocation(List<WeatherReportListLocDto> location) {
		this.location = location;
	}
	

	
}
