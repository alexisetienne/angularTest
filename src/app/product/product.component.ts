import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product;
  constructor(private httpClient:HttpClient) { }

  ngOnInit() {
  }
  onGetProduct() {
  this.httpClient.get("http://localhost:8080/products")
  .subscribe(data=> {
  this.product=data;
  }, err=>{
    console.log(err);
  })
  }
}
