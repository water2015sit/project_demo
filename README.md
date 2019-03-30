# project_demo

This is a demo for my android background.

This project currently has three major features: Fetching notification from internal database and display aggregated information using viewer pager and recycler view. Browse files stored in the local device. A build in web browser. We use a navigation drawer to help user navigate through the app.

This 1.0 version project has three layers, the bottom layer is the database layer. The middle tier is a data access layer convert raw cursor to our data models. The top layer is the UI layer which consumes our data model.

This project use android design library like View Pager, Recycler View, Navigation Drawer and Web View. I also use SQLite Database to store mock data for this app.

Next step would be setup server back-end. Establish server-client communication using ok-http. Use real network data to replace current mock data. We would to like to use RetroFit and OKHttp here and simplify our current data access layer.
