# UserApiApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cambiarPassword**](UserApiApi.md#cambiarPassword) | **PUT** /usuario/{idUser} | Cambiar contraseña |
| [**consultarUser**](UserApiApi.md#consultarUser) | **GET** /usuario/{id} | Consulta un usario |
| [**crearUsario**](UserApiApi.md#crearUsario) | **POST** /usuario | Crear un nuevo usuario |
| [**inicarSesion**](UserApiApi.md#inicarSesion) | **GET** /usuario | Iniciar sesion  |


<a id="cambiarPassword"></a>
# **cambiarPassword**
> cambiarPassword(idUser, cambiarPasswordRequest)

Cambiar contraseña

Permite cambiar la contraseña del usuario pasandole su id, antigua y nueva contraseña

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: Authorization
    ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Authorization.setApiKeyPrefix("Token");

    UserApiApi apiInstance = new UserApiApi(defaultClient);
    Long idUser = 56L; // Long | 
    CambiarPasswordRequest cambiarPasswordRequest = new CambiarPasswordRequest(); // CambiarPasswordRequest | 
    try {
      apiInstance.cambiarPassword(idUser, cambiarPasswordRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApiApi#cambiarPassword");
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
| **idUser** | **Long**|  | |
| **cambiarPasswordRequest** | [**CambiarPasswordRequest**](CambiarPasswordRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarUser"></a>
# **consultarUser**
> User consultarUser(id)

Consulta un usario

Permite consultar un usuario mediante una id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: Authorization
    ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Authorization.setApiKeyPrefix("Token");

    UserApiApi apiInstance = new UserApiApi(defaultClient);
    Long id = 56L; // Long | 
    try {
      User result = apiInstance.consultarUser(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApiApi#consultarUser");
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
| **id** | **Long**|  | |

### Return type

[**User**](User.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="crearUsario"></a>
# **crearUsario**
> User crearUsario(createUserRequest)

Crear un nuevo usuario

Permite crear un nuevo usuario

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: Authorization
    ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Authorization.setApiKeyPrefix("Token");

    UserApiApi apiInstance = new UserApiApi(defaultClient);
    CreateUserRequest createUserRequest = new CreateUserRequest(); // CreateUserRequest | 
    try {
      User result = apiInstance.crearUsario(createUserRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApiApi#crearUsario");
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
| **createUserRequest** | [**CreateUserRequest**](CreateUserRequest.md)|  | |

### Return type

[**User**](User.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="inicarSesion"></a>
# **inicarSesion**
> User inicarSesion(login, password)

Iniciar sesion 

Permite iniciar sesion medienate un usuario y un password

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: Authorization
    ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Authorization.setApiKeyPrefix("Token");

    UserApiApi apiInstance = new UserApiApi(defaultClient);
    String login = "login_example"; // String | 
    String password = "password_example"; // String | 
    try {
      User result = apiInstance.inicarSesion(login, password);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApiApi#inicarSesion");
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
| **login** | **String**|  | |
| **password** | **String**|  | |

### Return type

[**User**](User.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

