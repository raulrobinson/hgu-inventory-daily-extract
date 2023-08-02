package co.com.telefonica.ws.ui.controller;

import co.com.telefonica.ws.common.utils.Shield;
import co.com.telefonica.ws.persistence.entity.BpmInfo;
import co.com.telefonica.ws.services.HguService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/telefonica/v1/hgu-inventory-daily")
public class HguController {

    private final HguService service;

    @Autowired
    public HguController(HguService service) {
        this.service = service;
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
