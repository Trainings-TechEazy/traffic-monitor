output "public_ip" {
  value = aws_instance.spring_dev.public_ip
}

output "ssh_command" {
  value = "ssh -i ~/.ssh/id_rsa ec2-user@${aws_instance.spring_dev.public_ip}"
}
