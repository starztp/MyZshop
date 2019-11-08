package backend.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianyou.constant.PageinationConstant;
import com.tianyou.pojo.Product;
import com.tianyou.pojo.ProductTypepojo;
import com.tianyou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tianyou on 2019/11/8.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findall")
    public String findall(Integer PageNum,Model model){
        if(ObjectUtils.isEmpty(PageNum)){
            PageNum= PageinationConstant.PageNum;
        }
        //设置分页，参数为页码和每页大小
        PageHelper.startPage(PageNum,PageinationConstant.PageSize);
        List<Product> Products=productService.findallproduct();
        //将查询结果放入pageInfo对象
        PageInfo<Product> pageInfo=new PageInfo<>(Products);
        model.addAttribute("PageInfo",pageInfo);
        return "productManager";
    }
}
