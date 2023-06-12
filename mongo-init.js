db.createUser(
        {
            user: "customerdb",
            pwd: "customerdb",
            roles: [
                {
                    role: "readWrite",
                    db: "customerdb"
                }
            ]
        }
);