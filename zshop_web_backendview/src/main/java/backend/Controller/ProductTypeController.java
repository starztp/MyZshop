package backend.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianyou.constant.PageinationConstant;
import com.tianyou.constant.ResponseCodeConstant;
import com.tianyou.exception.ProductTypeExistException;
import com.tianyou.pojo.ProductTypepojo;
import com.tianyou.service.ProductTypeService;
import com.tianyou.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/findall")
    public String findall(Integer PageNum,Model model){
        //判断页码参数是否为空
        if(ObjectUtils.isEmpty(PageNum)){
            PageNum= PageinationConstant.PageNum;
        }
        //设置分页，参数为页码和每页大小
        PageHelper.startPage(PageNum,PageinationConstant.PageSize);
        List<ProductTypepojo> ProductTypes=productTypeService.findall();
        //将查询结果放入pageInfo对象
        PageInfo<ProductTypepojo> pageInfo=new PageInfo<>(ProductTypes);
        model.addAttribute("PageInfo",pageInfo);
        return "productTypeManager";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(String name){
        ResponseResult responseResult=new ResponseResult();
        System.out.println("ControllerproductTypeName:"+name);
        try {
            productTypeService.add(name);
            responseResult.setStatuscode(ResponseCodeConstant.ResponseStautsSuccess);
            responseResult.setMessage("添加成功");
        } catch (ProductTypeExistException e) {
            responseResult.setStatuscode(ResponseCodeConstant.ResponseStatusFail);
            responseResult.setMessage(e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductTypepojo findById(int id) throws ProductTypeExistException {
        ProductTypepojo productType=productTypeService.findbyid(id);
        return productType;
        //return ResponseResult.success(id);
    }

    @RequestMapping("/updatename")
    @ResponseBody
    public ResponseResult updatename(int id,String name) {
        try {
            productTypeService.updatename(id,name);
            return ResponseResult.success("修改成功");
        } catch (ProductTypeExistException e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/updatestatus")
    @ResponseBody
    public ResponseResult updatestatus(int id,int status){
        try {
            productTypeService.updatestatus(id,status);
            return ResponseResult.success("修改成功");
        } catch (ProductTypeExistException e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }
    @RequestMapping("/deletebyid")
    @ResponseBody
    public ResponseResult deletebyid(int id) {
        try {
            productTypeService.deletebyid(id);
            return ResponseResult.success("删除成功");
        } catch (ProductTypeExistException e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }
}
