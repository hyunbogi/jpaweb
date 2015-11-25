package com.hyunbogi.jpaweb.web.controller.debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/debug")
public class DebugController {
    /**
     * Request mapping 정보 페이지 (for debugging)
     */
    @RequestMapping("/mapping_info")
    public String mappingInfo() {
        return "debug/mapping_info";
    }
}
