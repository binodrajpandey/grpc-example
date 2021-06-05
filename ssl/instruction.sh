#!/bin/bash
# output files
# ca.key: Certificate Authority private key
# ca.crt: Certificate Authority trust certificate
# server.key: Server private key
# server.csr: Server certificate signing request
# server.crt: Server certificate signed by the CA
# server.pem: Conversion of server.key into a format gRPC likes

# Summary
# private files: ca.key, server.key, server.pem, server.crt
# share files: ca.crt (needed by the client), server.csr(needed by the CA)

# Change these CN's to match your hosts in your environment if needed.
SERVER_CN=localhost

# step 1: Generate Certificate Authority + Trust Certificate (ca.crt)
openssl genrsa -passout pass:1111 -des3 -out ca.key 4096
openssl req -passin pass:1111 -new -x509 -days 365 -key ca.key -out ca.crt -subj "/CN=${SERVER_CN}"

# step 2: Generate the server private key (server.key)
openssl genrsa -passout pass:1111 -des3 -out server.key 4096

# step 3: Get a certificate signing request from the CA (server.csr)
openssl req -passin pass:1111 -new  -key server.key -out server.csr -subj "/CN=${SERVER_CN}"

# step 4: Sign the certificate with the CA we created (it's called self signing) - server.crt
openssl x509 -req -passin pass:1111 -days 365 -in  server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt
# output
# Signature ok
# subject=/CN=localhost
# Getting CA Private Key

# step 5: Convert the server.key to .pem format(server.pem) - usable by gRPC
openssl pkcs8 -topk8 -nocrypt -passin pass:1111 -in server.key -out server.pem

