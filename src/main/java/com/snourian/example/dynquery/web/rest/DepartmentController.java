package com.snourian.example.dynquery.web.rest;

import com.snourian.example.dynquery.service.DepartmentService;
import com.snourian.micronaut.querydsl.QueryParameters;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.RequestBean;

import java.io.IOException;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Get("/populate")
    public HttpResponse<?> findById() throws IOException {
        departmentService.populate();
        return HttpResponse.ok();
    }

    @Get("/search/paged{?values*}")
    public HttpResponse<?> search(@RequestBean QueryParameters values, Pageable pageable) {
        return HttpResponse.ok(departmentService.search(values, pageable));
    }

    @Get("/search/list{?values*}")
    public HttpResponse<?> search(@RequestBean QueryParameters values) {
        return HttpResponse.ok(departmentService.search(values));
    }

}
