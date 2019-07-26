(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/app.component.html":
/*!**************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/app.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <div class=\"row\">\n    <div class=\"col-md-12\">\n      <div class=\"card bg-dark my-5\">\n        <div class=\"card-body\">\n          <h2 class=\"card-title text-center text-white py-3\">{{ title }}</h2>\n          <ul class=\"text-center list-inline py-3\">\n            <li class=\"list-inline-item\"><a routerLink=\"/videos\" class=\"btn btn-info\">Videos</a></li>\n            <li class=\"list-inline-item\"><a routerLink=\"/adduser\" class=\"btn btn-info\">Upload Video</a></li>\n          </ul>\n        </div>\n      </div>\n      <app-comments userId=\"abc\" videoId=\"1\"></app-comments>\n      <router-outlet></router-outlet>\n    </div>\n  </div>\n  <video class=\"center\" id=\"myVideo\" height=\"300\" width=\"420\" autoplay=\"autoplay\" controls>\n<!--    <source src=\"http://localhost:8080/videos/33\" type=\"video/mp4\">-->\n    Your current browser is unsupported.\n  </video>\n</div>\n<div>\n  <video class=\"center\" id=\"player\" height=\"300\" width=\"420\" autoplay=\"autoplay\" controls>\n    <source src=\"http://localhost:8080/videos/33\" type=\"video/mp4\">\n    Your current browser is unsupported.\n  </video>\n</div>\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/comments/comments.component.html":
/*!****************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/comments/comments.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h2>Comments</h2>\n<div>\n  <textarea [(ngModel)]=\"commentText\" placeholder=\"Add a comment\" rows=\"3\" cols=\"50\"></textarea><br/>\n  <button style=\"width: 50px; height: 30px;\" (click)=\"addComment()\">Add</button>\n</div>\n\n\n<section *ngFor=\"let comment of comments\">\n  <p>\n    <b>{{comment.userId}}</b> created the following comment at {{comment.createdDate}}\n  </p>\n  <p>\n    {{comment.text}}\n  </p>\n\n</section>\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/upload-video/upload-video.component.html":
/*!************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/upload-video/upload-video.component.html ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card my-5\">\n    <div class=\"card-body\">\n        <form (ngSubmit)=\"onSubmit()\" #userForm=\"ngForm\">\n            <div class=\"form-group\">\n                <label for=\"name\">Name</label>\n                <input type=\"text\" [(ngModel)]=\"video.id\"\n                       class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Video Title\"\n                       required #name=\"ngModel\">\n            </div>\n            <div [hidden]=\"!name.pristine\" class=\"alert alert-danger\">Name is required</div>\n            <div class=\"form-group\">\n                <label for=\"email\">Upload File</label>\n                <input type=\"text\" [(ngModel)]=\"video.videoName\"\n                       class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Upload\"\n                       required #name=\"ngModel\">\n                <div [hidden]=\"!video.pristine\" class=\"alert alert-danger\">Email is required</div>\n            </div>\n            <button type=\"submit\" [disabled]=\"!userForm.form.valid\" class=\"btn btn-info\">Submit</button>\n        </form>\n    </div>\n</div>"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/video-list/video-list.component.html":
/*!********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/video-list/video-list.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card my-5\">\n    <div class=\"card-body\">\n        <table class=\"table table-bordered table-striped\">\n            <thead class=\"thead-dark\">\n            <tr>\n                <th scope=\"col\">PLAY</th>\n                <th scope=\"col\">TITLE</th>\n                <th scope=\"col\">DOWNLOAD</th>\n            </tr>\n            </thead>\n            <tbody>\n            <tr *ngFor=\"let video of videos\">\n                <td> <button (click)=\"switchVideo(video)\"\n                             class=\"switchVid\">&#9658;</button> </td>\n                <td>{{ video.videoName }}</td>\n                <td><a href=\"{{ video.videoPath }}\">download</a></td>\n            </tr>\n            </tbody>\n        </table>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _upload_video_upload_video_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./upload-video/upload-video.component */ "./src/app/upload-video/upload-video.component.ts");
/* harmony import */ var _video_list_video_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./video-list/video-list.component */ "./src/app/video-list/video-list.component.ts");





var routes = [
    { path: 'videos', component: _video_list_video_list_component__WEBPACK_IMPORTED_MODULE_4__["VideoListComponent"] },
    { path: 'adduser', component: _upload_video_upload_video_component__WEBPACK_IMPORTED_MODULE_3__["UploadVideoComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".center {\n    margin-left: auto;\n    margin-right: auto;\n    display: block;\n    border: #333333;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxpQkFBaUI7SUFDakIsa0JBQWtCO0lBQ2xCLGNBQWM7SUFDZCxlQUFlO0FBQ25CIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuY2VudGVyIHtcbiAgICBtYXJnaW4tbGVmdDogYXV0bztcbiAgICBtYXJnaW4tcmlnaHQ6IGF1dG87XG4gICAgZGlzcGxheTogYmxvY2s7XG4gICAgYm9yZGVyOiAjMzMzMzMzO1xufSJdfQ== */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'Welcome to NewTube!';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/index.js!./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _comments_comments_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./comments/comments.component */ "./src/app/comments/comments.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _video_list_video_list_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./video-list/video-list.component */ "./src/app/video-list/video-list.component.ts");
/* harmony import */ var _upload_video_upload_video_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./upload-video/upload-video.component */ "./src/app/upload-video/upload-video.component.ts");
/* harmony import */ var _videoservice_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./videoservice.service */ "./src/app/videoservice.service.ts");











var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"],
                _comments_comments_component__WEBPACK_IMPORTED_MODULE_6__["CommentsComponent"],
                _video_list_video_list_component__WEBPACK_IMPORTED_MODULE_8__["VideoListComponent"],
                _upload_video_upload_video_component__WEBPACK_IMPORTED_MODULE_9__["UploadVideoComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"]
            ],
            providers: [_videoservice_service__WEBPACK_IMPORTED_MODULE_10__["VideoService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/comments.service.ts":
/*!*************************************!*\
  !*** ./src/app/comments.service.ts ***!
  \*************************************/
/*! exports provided: CommentsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentsService", function() { return CommentsService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");





var CommentsService = /** @class */ (function () {
    function CommentsService(http) {
        this.http = http;
    }
    CommentsService.prototype.getComments = function (videoId) {
        return this.http.get("http://localhost:8080/videos" + videoId + "/comments").pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getComments', null)));
    };
    CommentsService.prototype.addComment = function (videoId, userComment) {
        console.log("Video ID " + videoId);
        console.log(userComment);
        this.http.post("http://localhost:8080/videos" + videoId + "/comments", userComment).subscribe();
    };
    CommentsService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(error); // log to console instead
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])(result);
        };
    };
    CommentsService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
    ]; };
    CommentsService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], CommentsService);
    return CommentsService;
}());



/***/ }),

/***/ "./src/app/comments/comment.ts":
/*!*************************************!*\
  !*** ./src/app/comments/comment.ts ***!
  \*************************************/
/*! exports provided: Comment, VideoComments */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Comment", function() { return Comment; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VideoComments", function() { return VideoComments; });
var Comment = /** @class */ (function () {
    function Comment() {
    }
    return Comment;
}());

var VideoComments = /** @class */ (function () {
    function VideoComments() {
    }
    return VideoComments;
}());



/***/ }),

/***/ "./src/app/comments/comments.component.css":
/*!*************************************************!*\
  !*** ./src/app/comments/comments.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbW1lbnRzL2NvbW1lbnRzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/comments/comments.component.ts":
/*!************************************************!*\
  !*** ./src/app/comments/comments.component.ts ***!
  \************************************************/
/*! exports provided: CommentsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentsComponent", function() { return CommentsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _comment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./comment */ "./src/app/comments/comment.ts");
/* harmony import */ var _comments_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../comments.service */ "./src/app/comments.service.ts");




var CommentsComponent = /** @class */ (function () {
    function CommentsComponent(commentsService) {
        this.commentsService = commentsService;
        this.comments = [];
    }
    //page load(my component)
    //display
    CommentsComponent.prototype.ngOnInit = function () {
        var _this = this;
        console.log("VideoId === " + this.videoId); //debugging
        console.log("UserId === " + this.userId); //debugging
        // to call API
        this.commentsService.getComments(this.videoId).subscribe(function (videoComments) {
            _this.comments = videoComments.comments;
        });
    };
    CommentsComponent.prototype.addComment = function () {
        var _this = this;
        var comment = new _comment__WEBPACK_IMPORTED_MODULE_2__["Comment"]();
        comment.text = this.commentText;
        comment.userId = this.userId;
        this.commentsService.addComment(this.videoId, comment);
        this.commentsService.getComments(this.videoId).subscribe(function (videoComments) {
            _this.comments = videoComments.comments;
        });
    };
    CommentsComponent.ctorParameters = function () { return [
        { type: _comments_service__WEBPACK_IMPORTED_MODULE_3__["CommentsService"] }
    ]; };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])()
    ], CommentsComponent.prototype, "videoId", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])()
    ], CommentsComponent.prototype, "userId", void 0);
    CommentsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-comments',
            template: __webpack_require__(/*! raw-loader!./comments.component.html */ "./node_modules/raw-loader/index.js!./src/app/comments/comments.component.html"),
            styles: [__webpack_require__(/*! ./comments.component.css */ "./src/app/comments/comments.component.css")]
        })
    ], CommentsComponent);
    return CommentsComponent;
}());



/***/ }),

/***/ "./src/app/upload-video/upload-video.component.css":
/*!*********************************************************!*\
  !*** ./src/app/upload-video/upload-video.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3VwbG9hZC12aWRlby91cGxvYWQtdmlkZW8uY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/upload-video/upload-video.component.ts":
/*!********************************************************!*\
  !*** ./src/app/upload-video/upload-video.component.ts ***!
  \********************************************************/
/*! exports provided: UploadVideoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadVideoComponent", function() { return UploadVideoComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _video__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../video */ "./src/app/video.ts");
/* harmony import */ var _videoservice_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../videoservice.service */ "./src/app/videoservice.service.ts");





var UploadVideoComponent = /** @class */ (function () {
    function UploadVideoComponent(route, router, videoService) {
        this.route = route;
        this.router = router;
        this.videoService = videoService;
        this.video = new _video__WEBPACK_IMPORTED_MODULE_3__["Video"]();
    }
    UploadVideoComponent.prototype.onSubmit = function () {
        var _this = this;
        this.videoService.save(this.video).subscribe(function (result) { return _this.gotoUserList(); });
    };
    UploadVideoComponent.prototype.gotoUserList = function () {
        this.router.navigate(['/videos']);
    };
    UploadVideoComponent.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
        { type: _videoservice_service__WEBPACK_IMPORTED_MODULE_4__["VideoService"] }
    ]; };
    UploadVideoComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-upload-video',
            template: __webpack_require__(/*! raw-loader!./upload-video.component.html */ "./node_modules/raw-loader/index.js!./src/app/upload-video/upload-video.component.html"),
            styles: [__webpack_require__(/*! ./upload-video.component.css */ "./src/app/upload-video/upload-video.component.css")]
        })
    ], UploadVideoComponent);
    return UploadVideoComponent;
}());



/***/ }),

/***/ "./src/app/video-list/video-list.component.css":
/*!*****************************************************!*\
  !*** ./src/app/video-list/video-list.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3ZpZGVvLWxpc3QvdmlkZW8tbGlzdC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/video-list/video-list.component.ts":
/*!****************************************************!*\
  !*** ./src/app/video-list/video-list.component.ts ***!
  \****************************************************/
/*! exports provided: VideoListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VideoListComponent", function() { return VideoListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _videoservice_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../videoservice.service */ "./src/app/videoservice.service.ts");



var VideoListComponent = /** @class */ (function () {
    function VideoListComponent(videoService) {
        this.videoService = videoService;
    }
    VideoListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.videoService.findAll().subscribe(function (data) {
            _this.videos = data;
        });
    };
    VideoListComponent.prototype.switchVideo = function (video) {
        console.log(video.videoPath);
        var videoPlayer = document.getElementById('myVideo');
        //let videoPlayer = document.createElement("video");
        // if (videoPlayer.hasChildNodes()){
        //   videoPlayer.removeChild(videoPlayer.firstChild);
        // }
        var source = document.createElement('source');
        //let type = document.createElement('type');
        source.setAttribute('src', video.videoPath);
        source.setAttribute('type', video.videoType);
        videoPlayer.appendChild(source);
        //document.body.replaceChild(ogVideoPlayer, videoPlayer);
    };
    VideoListComponent.ctorParameters = function () { return [
        { type: _videoservice_service__WEBPACK_IMPORTED_MODULE_2__["VideoService"] }
    ]; };
    VideoListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-video-list',
            template: __webpack_require__(/*! raw-loader!./video-list.component.html */ "./node_modules/raw-loader/index.js!./src/app/video-list/video-list.component.html"),
            styles: [__webpack_require__(/*! ./video-list.component.css */ "./src/app/video-list/video-list.component.css")]
        })
    ], VideoListComponent);
    return VideoListComponent;
}());



/***/ }),

/***/ "./src/app/video.ts":
/*!**************************!*\
  !*** ./src/app/video.ts ***!
  \**************************/
/*! exports provided: Video */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Video", function() { return Video; });
var Video = /** @class */ (function () {
    function Video() {
    }
    return Video;
}());



/***/ }),

/***/ "./src/app/videoservice.service.ts":
/*!*****************************************!*\
  !*** ./src/app/videoservice.service.ts ***!
  \*****************************************/
/*! exports provided: VideoService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VideoService", function() { return VideoService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var VideoService = /** @class */ (function () {
    function VideoService(http) {
        this.http = http;
        this.videoUrl = 'http://localhost:8080/videos';
    }
    VideoService.prototype.findAll = function () {
        console.log(this.http.get(this.videoUrl));
        return this.http.get(this.videoUrl);
    };
    VideoService.prototype.save = function (video) {
        return this.http.post(this.videoUrl, video);
    };
    VideoService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
    ]; };
    VideoService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], VideoService);
    return VideoService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/kavyamuppalla/week8/FullStack.MicroWebApplication-Server/angular-videoproject/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es5.js.map
