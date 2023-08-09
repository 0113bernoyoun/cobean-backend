package com.cobean.backend.roasters.controller;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.model.BeanDTO;
import com.cobean.backend.roasters.domain.Roasters;
import com.cobean.backend.roasters.model.RoastersDTO;
import com.cobean.backend.roasters.service.RoastersService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roasters")
@RequiredArgsConstructor
public class RoastersController {

    private final RoastersService roastersService;

    @GetMapping("/find")
    public List<RoastersDTO> testAPI(){
            return roastersService.findAllRoasters();
    }
}
