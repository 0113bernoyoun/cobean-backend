package com.cobean.backend.roasters.model;

import com.cobean.backend.bean.domain.Bean;

import java.util.List;

public record RoastersDTO(Long id, String name, List<Bean> beanList) {
}
