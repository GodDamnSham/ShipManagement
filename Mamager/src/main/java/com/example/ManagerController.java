package com.example;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/managers")
public class ManagerController {
	ManagerService ms;
    FeignClientService fc;
	
	public ManagerController(ManagerService ms , FeignClientService fc) {
		this.ms = ms;
        this.fc = fc;
	}
	
	@GetMapping("/getManagers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = ms.getAllManager();
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable("id") Long id) {
        Manager manager = ms.getManagerByID(id);
        if (manager != null) {
            return ResponseEntity.ok(manager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/addManager")
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
        Manager createdManager = ms.addManager(manager);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdManager);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<productDTO> addProduct(@RequestBody productDTO productDTO) {
        productDTO p = this.fc.addProduct(productDTO).getBody();
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

}
