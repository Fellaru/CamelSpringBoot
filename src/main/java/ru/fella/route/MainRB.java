package ru.fella.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fella.service.SimpleServiceImpl;

/**
 * Маршруты Camel и конфигурация CXF
 */
@Component
public class MainRB extends RouteBuilder {

  @Autowired
  private CamelContext context;

  @Override
  public void configure() throws Exception {

      CamelContext camelContext = getContext();

      // Создаём CxfEndpoint и публикуем его
      CxfEndpoint cxfEndpoint = new CxfEndpoint();
      cxfEndpoint.setAddress("http://localhost:12139/soap/app");
      cxfEndpoint.setServiceClass(SimpleServiceImpl.class);
      cxfEndpoint.setCamelContext(camelContext);
      cxfEndpoint.setDataFormat(DataFormat.POJO);
      context.addEndpoint("SimpleServiceEndpoint", cxfEndpoint);

      // Маршрут для CxfEndpoint
      from(cxfEndpoint)
          .to("responseProcessor")
          .to("log:bar");
  }
}
