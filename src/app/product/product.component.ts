import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {CatalogService} from '../services/catalog.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  public product: any;
  public size:number=5;
  public currentPage:number=0;
  public totalPages:number;
  public pages:Array<number>;
  constructor(private catService:CatalogService) { }

  ngOnInit() {
  }
  onGetProduct() {
  this.catService.getProducts(this.currentPage,this.size)
  .subscribe(data=> {
  this.product=data;
  this.totalPages=data["page"].totalPages;
  this.pages= new Array<number>(this.totalPages);
  }, err=>{
    console.log(err);
  })
  }
}
