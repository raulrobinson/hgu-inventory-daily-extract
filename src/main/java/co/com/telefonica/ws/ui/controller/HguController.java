package co.com.telefonica.ws.ui.controller;

import co.com.telefonica.ws.services.HguService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/telefonica/v1/hgu-inventory-daily")
public class HguController {

    private final HguService service;

    @Autowired
    public HguController(HguService service) {
        this.service = service;
    }

    @GetMapping("/tbpm/{pageNumber}/{pageSize}")
    public ResponseEntity<Object> findCustomTBpmServiceImCpeInfo(@PathVariable int pageSize,
                                                                 @PathVariable int pageNumber) {
        var require = service.findCustomTBpmServiceImCpeInfo(pageNumber, pageSize);
        if (require.getStatusCode().is4xxClientError()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(require.getBody(), HttpStatus.OK);
    }

    @GetMapping("/model/{model}")
    public Long findCountModel(@PathVariable String model) {
        return service.findCountModel(model);
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public ResponseEntity<Object> findHguByCustomQuery(@PathVariable int pageSize,
                                                              @PathVariable int pageNumber) {
        var require = service.findHguByCustomQuery(pageSize, pageNumber );
        if (require.getStatusCode().is4xxClientError()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(require.getBody(), HttpStatus.OK);
    }
}
