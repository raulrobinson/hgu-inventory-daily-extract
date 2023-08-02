package co.com.telefonica.ws.ui.controller;

import co.com.telefonica.ws.services.HguService;
import co.com.telefonica.ws.ui.dto.CustomResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/telefonica/v1/hgu-inventory-daily")
public class HguController {

    private final HguService service;

    @Autowired
    public HguController(HguService service) {
        this.service = service;
    }

    @GetMapping("/try-test/{lotSize}")
    public ResponseEntity<Object> findCustomTBPM(@PathVariable int lotSize) {
        var require = service.findCustomTBPM(lotSize);
        if (require.getStatusCode().is4xxClientError()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(require.getBody(), HttpStatus.OK);
    }

    @GetMapping("/model/total")
    public ResponseEntity<Object> findCountModel() {
        var require = service.findCountModel();
        if (require.getStatusCode().is4xxClientError()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(require.getBody(), HttpStatus.OK);
    }

    @GetMapping("/results")
    public Page<CustomResult> getPaginatedResults(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return service.getPaginatedResults(page, size);
    }

}
