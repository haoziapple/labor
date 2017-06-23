package ${packageName}.controller.webpage;

import java.util.*;
import ${packageName}.model.${upperFirstLetterName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${packageName}.service.${upperFirstLetterName}Service;
import javax.annotation.Generated;
import ${packageName}.common.Page;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Generated(
    value = {
        "Labor version:1.0.0"
    },
    comments = "This class is generated by Labor"
)
@RestController
@ApiIgnore
@RequestMapping(value = "/p/${name}")
public class ${upperFirstLetterName}PageController {

	@Autowired
	private ${upperFirstLetterName}Service ${lowerFirstLetterName}Service;

	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		if (null != pageNo && pageNo != 1){
			mav.addObject("rows", ${lowerFirstLetterName}Service.page(pageNo, 10).getResult());
		}else{
			mav.addObject("rows", ${lowerFirstLetterName}Service.list());
		}
		mav.setViewName("/${upperFirstLetterName}List");
		return mav;
	}

	@RequestMapping(value = "/detail/{${primaryKey}}", method= RequestMethod.GET)
	public ModelAndView detail(@PathVariable ${primaryKeyType} ${primaryKey}) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", ${lowerFirstLetterName}Service.getBy${upperFirstLetterPrimaryKey}(${primaryKey}));
		mav.setViewName("/${upperFirstLetterName}Detail");
		return mav;
	}

	@RequestMapping(value = "/create", method= RequestMethod.GET)
		public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/${upperFirstLetterName}Create");
		return mav;
	}

}
