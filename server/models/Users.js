module.exports = (sequelize, { DataTypes }) => {
    const User = sequelize.define(
        "User",
        {
            name: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            email: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            password: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            age:{
                type:DataTypes.STRING
            },
        },
        {
            sequelize,
            tableName:'users',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return User;
};