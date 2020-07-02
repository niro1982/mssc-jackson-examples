package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"1f8bf950-4d4c-40cf-8f77-1ac5d7816f93\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.9900000000000002131628207280300557613372802734375,\"createdDate\":\"2020-07-02T21:08:00.3370108+03:00\",\"lastUpdatedDate\":\"2020-07-02T21:08:00.3390102+03:00\"}";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(dto);
    }

}