package ${packageName};

import java.util.Formatter;

public class ${className} {

  <#list list as prop>
  private ${prop.type} ${prop.name};

  </#list>
  <#list list as prop>
  public ${prop.type} get${prop.name?cap_first}(){
    return ${prop.name};
  }

  public void set${prop.name?cap_first}(${prop.type} ${prop.name}){
    this.${prop.name} = ${prop.name};
  }

  </#list>

  public static String packData(${className} obj) {
    StringBuffer buff = new StringBuffer();
    Formatter format = new Formatter(buff);

    format.format("${formatStr}", <#list list as prop><#if prop_has_next>obj.get${prop.name?cap_first}(), <#else>obj.get${prop.name?cap_first}()</#if></#list>);
    format.close();

    return buff.toString();
  }

}