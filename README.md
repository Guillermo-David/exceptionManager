# ExceptionManager

## Descripción
Esta sencilla tool permite lanzar excepciones personalizadas con un código de respuesta y un mensaje personalizados.

## Funcionamiento
- La clase ErrorCode tiene un único método estático `ErrorCode.get(String errorCode)`. El parámetro que recibe se utiliza para buscar la información 
relativa a la excepción que se desea lanzar. 

- En la carpeta *src/main/resources* debe existir un archivo llamado `ErrorCode.json` con la siguiente estructura:
```sh
{
  "ERROR1":
  {
    "code":404,
    "msg":"No se ha encontrado"
  },
  "ERROR2":
  {
    "code":500,
    "msg":"Todo mal"
  }
}
```


- Para lanzar una excepción, se deberá llamar a uno de los siguientes constructores:

```sh
throw new ServiceException("ERROR1");
```
```sh
ErrorCode error = ErrorCode.get("ERROR1");
throw new ServiceException(HttpStatusCode.valueOf(error.getCode(), error.getMsg());
```
```sh
ErrorCode error = ErrorCode.get("ERROR1");
throw new ServiceException(error.getCode(), error.getMsg());
```
