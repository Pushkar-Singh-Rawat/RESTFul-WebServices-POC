package demo.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	@ApiModelProperty(value="This is the firstname",required=true)
	private String firstname;
	@ApiModelProperty(value="This is the lastname",required=true)
	private String lastname;
	@JsonProperty("customer_url")
	private String customerURL;
	/*private Long Id;*/
}
