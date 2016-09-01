#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ${package}.common.RestServiceRequest;
import ${package}.common.RestServiceResponse;

@RestController
public class SpringJacksonRestController {

	private static final String FILE_PATH = "D:${symbol_escape}${symbol_escape}FPWT-Service${symbol_escape}${symbol_escape}iPru_template v5.pdf";
	
	@RequestMapping(value = "/pdf/post", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody RestServiceResponse createPdf(@RequestBody String jsonInput) {

		RestServiceResponse object = new RestServiceResponse();

		String base64Value = Base64.getEncoder().encodeToString(fileToByteArray(FILE_PATH));
		ObjectMapper mapper = new ObjectMapper();
		try {
			RestServiceRequest restServiceRequest = mapper.readValue(jsonInput, RestServiceRequest.class);
			

		}
		catch(JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return object;

	}

	// TODO: Test purpose methods
	@RequestMapping(value = "/pdf/Base64/Get", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getBase64ValuePdf() {

		String base64Value = Base64.getEncoder().encodeToString(fileToByteArray(FILE_PATH));
		return base64Value;
	}
	
	public static byte[] fileToByteArray(String fileName) {
		try {
			File f = new File(fileName);
			FileInputStream in = new FileInputStream(f);
			byte[] bytes = new byte[(int) f.length()];
			int c = -1;
			int ix = 0;
			while((c = in.read()) > -1) {
				// System.out.println(c);
				bytes[ix] = (byte) c;
				ix++;
			}
			in.close();
			return bytes;
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
