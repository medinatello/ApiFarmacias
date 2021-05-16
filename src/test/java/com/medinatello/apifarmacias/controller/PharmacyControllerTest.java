package com.medinatello.apifarmacias.controller;

import com.medinatello.apifarmacias.dto.PharmacyDTO;
import com.medinatello.apifarmacias.service.PharmacyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PharmacyController.class)
public class PharmacyControllerTest {

    private PharmacyController controller;
    @MockBean
    private PharmacyService service;

    @Test
    @DisplayName("ping services online")
    public void pingTest() throws Exception{
        var pong = "pong";
        controller = new PharmacyController(service);
        var response = controller.ping();
        var body = response.getBody();
        assertThat(response.getStatusCode().value(), equalTo(HttpStatus.OK.value()));
        assertThat(pong, equalTo( body ) );
    }

    @Test
    @DisplayName("getAll pharmacies")
    public void getAll(){
        List<PharmacyDTO> pharmacyDTOS = getDTO(20);
        service = mock(PharmacyService.class);
        controller = new PharmacyController(service);
        when(service.getPharmacies("")).thenReturn(pharmacyDTOS);

        var response = controller.getAll(Optional.empty());
        List<PharmacyDTO> pharmacyResponse = response.getBody();

        assertThat(response.getStatusCode().value(), equalTo(HttpStatus.OK.value()));
        assertThat(pharmacyResponse.stream().count(), equalTo(pharmacyDTOS.stream().count()));
    }

    @Test
    @DisplayName("getAll pharmacies not found")
    public void getAllNotFound(){
        List<PharmacyDTO> pharmacyDTOS = getDTO(0);
        service = mock(PharmacyService.class);
        controller = new PharmacyController(service);
        when(service.getPharmacies("")).thenReturn(pharmacyDTOS);

        var response = controller.getAll(Optional.empty());
        List<PharmacyDTO> pharmacyResponse = response.getBody();

        assertThat(response.getStatusCode().value(), equalTo(HttpStatus.NOT_FOUND.value()));

    }


    @Test
    @DisplayName("getAll pharmacies Error")
    public void getAllError(){
        service = mock(PharmacyService.class);
        controller = new PharmacyController(service);
        when(service.getPharmacies("")).thenReturn(null);

        var response = controller.getAll(Optional.empty());
        List<PharmacyDTO> pharmacyResponse = response.getBody();

        assertThat(response.getStatusCode().value(), equalTo(HttpStatus.INTERNAL_SERVER_ERROR.value()));

    }


    private List<PharmacyDTO> getDTO(int count){
        List<PharmacyDTO> output = new ArrayList<>();
        for (int i=0; i<count;i++){

            var pharmacyDTO = new PharmacyDTO();
            pharmacyDTO.setName("La reina" + i);
            pharmacyDTO.setPhone("99999 " + i);
            pharmacyDTO.setAddress("La reina 123" + i);
            pharmacyDTO.setLatitud("33.3996351" + i);
            pharmacyDTO.setLongitud("-70.628949" + i);

            output.add(pharmacyDTO);
        }

        return output;
    }


}
