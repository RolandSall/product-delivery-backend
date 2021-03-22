cd ./company_service
docker build -t rolandsall24/company_service:1.0.0 .

cd ../

cd ./product_service
docker build -t rolandsall24/product_service:1.0.0 .

cd ../

cd ./gateway_service
docker build -t rolandsall24/gateway_service:1.0.0 .