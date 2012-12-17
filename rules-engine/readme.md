Rules Engine
===========



URL WSDL
=======
http://localhost:8080/rules-engine/SimpleGenericWebService?wsdl



Modo de invocacion de Web Services
==================================

<?xml version="1.0" encoding="utf-8" standalone="yes" ?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" >
<soap:Header>
</soap:Header>
<soap:Body>
<ws.e:ventaCargaMonton xmlns:ws.e="http://ws.engine.claro.redhat.com/">
<arg0>1</arg0>
<arg1>2</arg1>
</ws.e:ventaCargaMonton>
</soap:Body>
</soap:Envelope>




Respuesta
========

<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Header/>
    <soap:Body>
        <ns2:ventaCargaMontonResponse xmlns:ns2="http://ws.engine.claro.redhat.com/">
            <return>false</return>
        </ns2:ventaCargaMontonResponse>
    </soap:Body>
</soap:Envelope>






