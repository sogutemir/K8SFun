Write-Host "Docker imajlarını hazırlama" -ForegroundColor Green

# Docker Compose imajını aynı isimde bırakıyoruz
# k8sexercisetodoapp-app:latest

Write-Host "Docker imajları hazırlanmıştır. Kubernetes için kullanılabilir durumda." -ForegroundColor Green
Write-Host "İmaj listesi:" -ForegroundColor Yellow
docker images | findstr k8sexercisetodoapp-app 