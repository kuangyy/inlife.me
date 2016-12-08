<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <jsp:include page="/WEB-INF/jsp/commons/resources.jsp"/>

    <title>asd</title>
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body class="logged-out sticky">

<div id="content">

    <jsp:include page="/WEB-INF/jsp/commons/header.jsp"/>

    <div class="yield">
        <div id="search-mode" style="display:none;">
            <div class="js-product-search-section">
                <div class="js-message search-message">
                </div>
                <div class="js-empty-state">
                </div>
                <div class="js-results-container"></div>
                <div class="js-spinner product-search-spinner">
                    <div class="vertical-center-outer">
                        <div class="vertical-center-inner">
                            <div class="product-loader-icon search animated spin">
                  <span>
                    Loading...
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="js-asin-search-section cards-container amazon-search-container show-glyph-actions ready">
                <div class="js-message search-message search-summary search-summary-big">
                    Found it. <span>You can Like this product or add it to a collection, right from here.</span>
                </div>
                <div class="js-empty-state">
                    Sorry, we couldn't find a product with that link.
                </div>
                <div class="centered-results feed-list js-results-container wrapper"></div>
                <div class="js-spinner product-search-spinner">
                    <div class="vertical-center-outer">
                        <div class="vertical-center-inner">
                            <div class="product-loader-icon search animated spin">
                  <span>
                    Loading...
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="js-canopy-search-section cards-container amazon-search-container show-glyph-actions ready">
                <div class="js-message search-message search-summary search-summary-big">
                    Found it. <span>You can Like this product or add it to a collection, right from here.</span>
                </div>
                <div class="js-empty-state">
                    Sorry, we couldn't find a product with that link.
                </div>
                <div class="centered-results feed-list js-results-container wrapper"></div>
                <div class="js-spinner product-search-spinner">
                    <div class="vertical-center-outer">
                        <div class="vertical-center-inner">
                            <div class="product-loader-icon search animated spin">
                  <span>
                    Loading...
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 列表 -->
        <div id="browse-mode">
            <div class="nav-level">
                <div class="nav-level-layout wrapper">
                    <div class="PageTabs">
                        <a class="page-section-tab active" href="">编辑推荐</a>


                        <a class="page-section-tab " href="">人文纪实</a>
                        <a class="page-section-tab " href="">街头</a>
                        <a class="page-section-tab " href="">新闻</a>
                        <a class="page-section-tab " href="">自然风景</a>
                        <a class="page-section-tab " href="">建筑</a>
                        <a class="page-section-tab " href="">Fine Art</a>
                        <a class="page-section-tab " href="">时尚广告</a>


                    </div>
                </div>
            </div>
            <div data-react-class="FeedList"
                 data-react-props="{&quot;path&quot;:&quot;/ajax/merged_feed_products&quot;,&quot;pageSize&quot;:18,&quot;subsection&quot;:&quot;trending&quot;}">
                <div data-reactroot="" class="wrapper feed-list">
                    <div class="">

                        <div class="feed-card product-card second-feed-card">

                            <a href="Photography projectdetails1.htm"
                               class="product-card-body fancybox fancybox-wide fancybox.ajax product-link-tracking">
                                <div class="card-body">
                                    <div class="product-card-image"><img
                                            src="http://ofopoqreb.bkt.clouddn.com/123123asdjas.jpg" class=""></div>
                                    <div class="product-card-details">
                                        <div class="product-details-name"><span class="text-underline">Jakub Karwowski: Famliy家庭项目</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                            <div class="card-footer">
                                <div class="feed-card-footer">
                                    <div class="footer-left-side trending-content">
                                        <i class="fa fa-eye fa3" aria-hidden="true"></i><span>68</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="feed-card product-card second-feed-card">

                            <a href="Photography projectdetails1.htm"
                               class="product-card-body fancybox fancybox-wide fancybox.ajax product-link-tracking">
                                <div class="card-body">
                                    <div class="product-card-image"><img
                                            src="http://www.padmag.cn/wp-content/uploads/634.jpg" class=""></div>
                                    <div class="product-card-details">
                                        <div class="product-details-name"><span class="text-underline">Tarasov Maksim: 无人机摄影作品</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                            <div class="card-footer">
                                <div class="feed-card-footer">
                                    <div class="footer-left-side trending-content">
                                        <i class="fa fa-eye fa3" aria-hidden="true"></i><span>78</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="feed-card product-card second-feed-card">

                            <a href="Photography projectdetails1.htm"
                               class="product-card-body fancybox fancybox-wide fancybox.ajax product-link-tracking">
                                <div class="card-body">
                                    <div class="product-card-image"><img
                                            src="http://www.padmag.cn/wp-content/uploads/07-3-960x636.jpg" class="">
                                    </div>
                                    <div class="product-card-details">
                                        <div class="product-details-name"><span class="text-underline">Heiko Gerlicher: 森林</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                            <div class="card-footer">
                                <div class="feed-card-footer">
                                    <div class="footer-left-side trending-content">
                                        <i class="fa fa-eye fa3" aria-hidden="true"></i><span>158</span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="InfiniteScrollFooter is-showingLoadMoreButton InfiniteScrollFooter--fullWidth">
                            <div class="LoadMoreButton FeedLoadMore">加载更多</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--  列表结束-->
    </div>

</div>


<jsp:include page="/WEB-INF/jsp/commons/footer.jsp"/>

</body>
</html>
