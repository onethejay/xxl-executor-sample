package com.example.xxlexecutorsample;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleService {

    @XxlJob("sampleJobHandler")
    public void sampleXxlJob() {
        String str = "이것도 가능합니다.";
        XxlJobHelper.log("여기에 로그를 작성하면 확인할 수 있습니다. {}", str);

        // param parse
        String param = XxlJobHelper.getJobParam();
        if (param==null || param.trim().length()==0) {
            XxlJobHelper.log("param["+ param +"] invalid.");

            XxlJobHelper.handleFail();
        }

        XxlJobHelper.log("입력된 param은 {} 입니다.", param);

        Map<String, String> paramMap = new HashMap<>();
        if (param != null) {
            String[] paramArr = param.split("=");
            paramMap.put("key", paramArr[0]);
            paramMap.put("value", paramArr[1]);

            XxlJobHelper.log("입력된 param을 split하여 map에 넣은 값은 {} 입니다.", paramMap);
        }
    }
}
