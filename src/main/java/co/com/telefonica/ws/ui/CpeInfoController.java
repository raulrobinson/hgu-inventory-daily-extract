package co.com.telefonica.ws.ui;

import co.com.telefonica.ws.persistence.entity.CpeInfoEntity;
import co.com.telefonica.ws.services.CpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpe-info")
public class CpeInfoController {

    private final CpeService cpeService;

    @Autowired
    public CpeInfoController(CpeService cpeService) {
        this.cpeService = cpeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CpeInfoEntity>> getCpeInfoList() {
        List<CpeInfoEntity> cpeInfoList = cpeService.getCpeInfoList();
        if (cpeInfoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cpeInfoList, HttpStatus.OK);
    }

    @GetMapping("/page/{pageSize}/{pageNumber}")
    public ResponseEntity<Page<CpeInfoEntity>> getCpeInfoPage(@PathVariable int pageSize,
                                                              @PathVariable int pageNumber) {
        Page<CpeInfoEntity> cpeInfoList = cpeService.getCpeInfoEntityByModel(pageSize, pageNumber);
        if (cpeInfoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cpeInfoList, HttpStatus.OK);
    }

}

