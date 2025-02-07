# PedidoApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**aadirDetallePedido**](PedidoApiServiceApi.md#aadirDetallePedido) | **POST** /pedidoActualizar | Añadir detalle pedido |
| [**buscarPedidosEntreFechas**](PedidoApiServiceApi.md#buscarPedidosEntreFechas) | **GET** /pedidoFechas | Consulta lista pedidos por dos fechas |
| [**consultarPedido**](PedidoApiServiceApi.md#consultarPedido) | **GET** /pedidoId | Consulta pedido por id |
| [**consultarPedidoCliente**](PedidoApiServiceApi.md#consultarPedidoCliente) | **GET** /pedidoDni/{dni} | Consulta lista pedidos por dni |
| [**registrarPedido**](PedidoApiServiceApi.md#registrarPedido) | **POST** /pedido | Registrar pedido nuevo |


<a id="aadirDetallePedido"></a>
# **aadirDetallePedido**
> Pedido aadirDetallePedido(id, pedidoDetalle)

Añadir detalle pedido

Permite añadir detalle de pedido a un pedido

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    PedidoDetalle pedidoDetalle = new PedidoDetalle(); // PedidoDetalle | 
    try {
      Pedido result = apiInstance.aadirDetallePedido(id, pedidoDetalle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#aadirDetallePedido");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **pedidoDetalle** | [**PedidoDetalle**](PedidoDetalle.md)|  | |

### Return type

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="buscarPedidosEntreFechas"></a>
# **buscarPedidosEntreFechas**
> List&lt;Pedido&gt; buscarPedidosEntreFechas(fecha1, fecha2)

Consulta lista pedidos por dos fechas

Consulta una lista de pedidos entre dos fechas

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    LocalDate fecha1 = LocalDate.now(); // LocalDate | 
    LocalDate fecha2 = LocalDate.now(); // LocalDate | 
    try {
      List<Pedido> result = apiInstance.buscarPedidosEntreFechas(fecha1, fecha2);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#buscarPedidosEntreFechas");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **fecha1** | **LocalDate**|  | [optional] |
| **fecha2** | **LocalDate**|  | [optional] |

### Return type

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedido"></a>
# **consultarPedido**
> Pedido consultarPedido(id)

Consulta pedido por id

Consulta un pedido mediante una id y lo devuelve

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Pedido result = apiInstance.consultarPedido(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#consultarPedido");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedidoCliente"></a>
# **consultarPedidoCliente**
> List&lt;Pedido&gt; consultarPedidoCliente(dni)

Consulta lista pedidos por dni

Consulta una lista de pedido mediante un dni del cliente

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String dni = "dni_example"; // String | 
    try {
      List<Pedido> result = apiInstance.consultarPedidoCliente(dni);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#consultarPedidoCliente");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dni** | **String**|  | |

### Return type

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="registrarPedido"></a>
# **registrarPedido**
> String registrarPedido(pedido)

Registrar pedido nuevo

Permite registrar un nuevo pedido completo

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    Pedido pedido = new Pedido(); // Pedido | 
    try {
      String result = apiInstance.registrarPedido(pedido);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#registrarPedido");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **pedido** | [**Pedido**](Pedido.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

