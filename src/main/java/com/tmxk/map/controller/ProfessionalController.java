package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ProfessionalEntity;
import com.tmxk.map.service.ProfessionalService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 专业人才
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/professional")
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = professionalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{professionalId}")
    public R info(@PathVariable("professionalId") Integer professionalId){
		ProfessionalEntity professional = professionalService.getById(professionalId);

        return R.ok().put("professional", professional);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProfessionalEntity professional){
		professionalService.save(professional);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ProfessionalEntity professional){
		professionalService.updateById(professional);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] professionalIds){
		professionalService.removeByIds(Arrays.asList(professionalIds));

        return R.ok();
    }

}
