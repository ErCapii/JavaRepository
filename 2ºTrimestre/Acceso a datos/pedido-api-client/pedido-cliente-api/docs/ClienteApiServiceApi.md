# ClienteApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**actualizarCliente**](ClienteApiServiceApi.md#actualizarCliente) | **PUT** /cliente | Actualiza un cliente existente |
| [**consultarClientPorDni**](ClienteApiServiceApi.md#consultarClientPorDni) | **GET** /cliente | Consulta de cliente por dni |
| [**consultarClientePorId**](ClienteApiServiceApi.md#consultarClientePorId) | **GET** /cliente/{id} | Consulta de cliente por id |
| [**crearCliente**](ClienteApiServiceApi.md#crearCliente) | **POST** /cliente | Crear un cliente nuevo |


<a id="actualizarCliente"></a>
# **actualizarCliente**
> Cliente actualizarCliente(cliente)

Actualiza un cliente existente

Permite actualizar un cliente

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    Cliente cliente = new Cliente(); // Cliente | 
    try {
      Cliente result = apiInstance.actualizarCliente(cliente);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#actualizarCliente");
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
| **cliente** | [**Cliente**](Cliente.md)|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarClientPorDni"></a>
# **consultarClientPorDni**
> Cliente consultarClientPorDni(dni)

Consulta de cliente por dni

Permite obetner un cliente por su dni

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    String dni = "dni_example"; // String | 
    try {
      Cliente result = apiInstance.consultarClientPorDni(dni);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#consultarClientPorDni");
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

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarClientePorId"></a>
# **consultarClientePorId**
> Cliente consultarClientePorId(id)

Consulta de cliente por id

Permite obetner un cliente por su id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Cliente result = apiInstance.consultarClientePorId(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#consultarClientePorId");
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

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="crearCliente"></a>
# **crearCliente**
> Cliente crearCliente(cliente)

Crear un cliente nuevo

Permite crear un cliente

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    Cliente cliente = new Cliente(); // Cliente | 
    try {
      Cliente result = apiInstance.crearCliente(cliente);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#crearCliente");
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
| **cliente** | [**Cliente**](Cliente.md)|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

